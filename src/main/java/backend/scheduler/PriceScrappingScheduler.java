package backend.scheduler;


import backend.product.entity.Product;
import backend.product.repository.ProductRepositoryImpl;
import dorkbox.notify.Notify;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class PriceScrappingScheduler {

    /**
     * Product price state
     * STABLE: Price didn't change
     * INCREASED: Price increased
     * DECREASED: Price decreased
     */
    enum PriceState {
        STABLE, INCREASED, DECREASED
    }

    /**
     * Thread Pool Executor
     */
    public ThreadPoolExecutor threadPoolExecutor;

    /**
     * ProductRepositoryImpl
     */
    public ProductRepositoryImpl productRepository;

    /**
     * Initiate threadPoolExecutor with 5 threads.
     * Initialize productRepository object.
     */
    public PriceScrappingScheduler() {
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        productRepository = new ProductRepositoryImpl();
    }

    /**
     * Cron job execution gateway
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        PriceScrappingScheduler priceScrappingScheduler = new PriceScrappingScheduler();
        priceScrappingScheduler.scheduler();
    }

    /**
     * Using thread pool, scheduler do the web scrapping part to get current price of all
     * products and sends notification accordingly.
     */
    public void scheduler() {
        Optional<Set<Product>> optionalProductSet = productRepository.findAll();

        if (optionalProductSet.isPresent()) {
            Set<Product> productSet = optionalProductSet.get();
            productSet.forEach(product ->
                    threadPoolExecutor.submit(() -> calculatePriceAndSendNotification(product))
            );
        }
    }

    /**
     * Invoke crawlAndGetCurrentPrice() method to get current price
     * Invoke comparePrice() method to compare price and get price state
     * Invoke notifier() method to notify according to the price state.
     *
     * @param product Product
     */
    public void calculatePriceAndSendNotification(Product product) {
        try {
            double currentPrice = crawlAndGetCurrentPrice(product.getUrl(),
                                                          product.getPriceSelector());
            PriceState priceState = comparePrice(currentPrice, product.getPrice());
            notifier(priceState, product.getName(), currentPrice);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Using jsoup package visit the url of the given product and scrap its current price
     *
     * @param url Product Url
     * @param priceSelector Product PriceSelector
     * @return current price
     * @throws IOException IOException
     */
    public double crawlAndGetCurrentPrice(String url, String priceSelector) throws IOException {
        Document document = Jsoup.connect(url).get();
        Element priceElement = document.getElementById(priceSelector);

        return Double.parseDouble(priceElement.text());
    }

    /**
     * Compares two price and returns PriceState
     *
     * @param currentPrice Current price
     * @param oldPrice Old price
     * @return PriceState (PriceState.INCREASED or PriceState.DECREASED or PriceState.STABLE)
     */
    public PriceState comparePrice(double currentPrice, double oldPrice) {
        return currentPrice > oldPrice ? PriceState.INCREASED : currentPrice < oldPrice ?
                PriceState.DECREASED : PriceState.STABLE;
    }

    /**
     * Build and return notification title according to price state
     *
     * @param priceState PriceState of product
     * @return notification title
     */
    public String buildNotificationTitle(PriceState priceState) {
        return switch (priceState) {
            case INCREASED -> "Price Increased";
            case DECREASED -> "Price Decreased";
            case STABLE -> "Price Stable";
        };
    }

    /**
     * Build notification text with given product name and current price from web scrapping results
     *
     * @param productName Product name
     * @param currentPrice Product price
     * @return Notification text
     */
    public String buildNotificationText(String productName, double currentPrice) {
        return "Current Price of " + productName + " : " + currentPrice;
    }

    /**
     * Send desktop notification according to price state
     *
     * @param priceState PriceState of product
     * @param productName Product name
     * @param currentPrice Current price
     */
    public void notifier(PriceState priceState, String productName, double currentPrice) {
        Notify notify = Notify.create()
                .title(buildNotificationTitle(priceState))
                .text(buildNotificationText(productName, currentPrice))
                .darkStyle();

        switch (priceState) {
            case INCREASED -> notify.showWarning();
            case DECREASED -> notify.showConfirm();
            case STABLE -> notify.showInformation();
        }
    }
}
