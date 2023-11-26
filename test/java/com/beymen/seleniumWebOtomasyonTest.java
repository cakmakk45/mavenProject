package com.beymen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class seleniumWebOtomasyonTests {


	public class BeymenAutomation {

		public static void main(String[] args) {
			// WebDriver'ı yükleyin
			System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			// Web sitesini açın
			driver.get("https://www.beymen.com");

			// Ana sayfanın açıldığını kontrol edin
			if (driver.getTitle().contains("Beymen")) {
				System.out.println("Ana sayfa başarıyla açıldı.");
			} else {
				System.out.println("Hata: Ana sayfa açılamadı!");
				driver.quit();
				return;
			}

			// Arama kutucuğuna "şort" kelimesini girin
			String searchKeyword = "şort";
			WebElement searchBox = driver.findElement(By.id("search"));
			searchBox.sendKeys(searchKeyword);

			// Arama kutucuğuna girilen "şort" kelimesini silin
			searchBox.clear();

			// Arama kutucuğuna "gömlek" kelimesini girin
			String searchKeywordGomlek = "gömlek";
			searchBox.sendKeys(searchKeywordGomlek);
			searchBox.sendKeys(Keys.ENTER);

			// Sonuca göre sergilenen ürünlerden rastgele bir ürün seçin
			List<WebElement> productResults = driver.findElements(By.cssSelector(".product-item"));
			if (!productResults.isEmpty()) {
				Random random = new Random();
				int randomIndex = random.nextInt(productResults.size());
				WebElement selectedProduct = productResults.get(randomIndex);

				// Seçilen ürünün bilgilerini alın
				String productName = selectedProduct.findElement(By.cssSelector(".product-name")).getText();
				String productPrice = selectedProduct.findElement(By.cssSelector(".product-price")).getText();

				// Bilgileri bir dosyaya yazın (Örnek olarak, konsola yazdırılmıştır)
				System.out.println("Seçilen Ürün: " + productName);
				System.out.println("Ürün Fiyatı: " + productPrice);

				// Seçilen ürünü sepete ekleyin
				selectedProduct.findElement(By.cssSelector(".add-to-cart-button")).click();

				// Sepetteki ürünün fiyatını kontrol edin
				String cartPrice = driver.findElement(By.cssSelector(".cart-total")).getText();
				if (productPrice.equals(cartPrice)) {
					System.out.println("Ürün fiyatları doğrulandı.");
				} else {
					System.out.println("Hata: Ürün fiyatları eşleşmiyor!");
				}

				// Adet arttırılarak ürün adedinin 2 olduğunu doğrulayın
				driver.findElement(By.cssSelector(".increase-quantity")).click();
				String quantity = driver.findElement(By.cssSelector(".quantity")).getText();
				if (quantity.equals("2")) {
					System.out.println("Ürün adedi doğrulandı.");
				} else {
					System.out.println("Hata: Ürün adedi eşleşmiyor!");
				}

				// Ürünü sepetten silerek sepetin boş olduğunu kontrol edin
				driver.findElement(By.cssSelector(".remove-product")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				if (driver.findElement(By.cssSelector(".empty-cart-message")).isDisplayed()) {
					System.out.println("Ürün başarıyla sepetten silindi. Sepet boş.");
				} else {
					System.out.println("Hata: Ürün silinemedi veya sepet boş değil!");
				}
			} else {
				System.out.println("Hata: Ürün bulunamadı!");
			}

			// WebDriver'ı kapatın
			driver.quit();
		}
	}

}
