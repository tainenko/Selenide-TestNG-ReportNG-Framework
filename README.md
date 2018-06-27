# Selenide-TestNG-ReportNG-Framework

ETmall 自動化測試框架，主要由以下的API組成：

Selenide:基於Selenium開發的套件，優化PageObject操作，測試失敗自動截圖，Browser在測試結果或測試失敗時自動關閉。

TestNG:測試框架。

ReportNG:美化HTML格式報告，產生xml格式報告給Jenkins。

Maven:

Tess4j:圖像辨識API，用於會員登入頁的驗證碼辨識。

## Update Note

2018/06/01:

確定PageObject的架構包含WebElement、Action、Assert。

測試框架由cucumber改為TestNG。

對WebDriver進行封裝。

2018/06/11:

引進Selenide(基於Selenium二次開發的API)，簡化selenium的架構，提昇程式的可讀性與可維護性，Selenide具有log、fail時自動截圖、測試失敗時自動關閉webdriver功能。

引進ReportNG：產生HTML與xml兩種格式的Report。

AutomationTesting的架構定為PageObject和Test files，前者包含WebElement、Action，後者純粹call Action去實作Test Steps。

Project上傳至Gitlab:柯泰年 / Selenide-TestNG-ReportNG-Framework

2018/06/19

完成Test Case參數化。TestData會讀取csv檔生成測試案例。

完成會員登入頁驗證碼辨識api(with tess4j OCR)。

2018/06/21

優化驗證碼圖片之干擾線處理方法

2018/06/22

更新 PageObject 註冊頁和註冊流程測試

2018/06/27

完善註冊頁和註冊流程測試，加入一個getVeriySN的method可以取得Lab區的手機驗証碼。 

### 已實裝功能

-PageObject、Webdriver封裝

-Configuration可以設定不同Browser(Chrome、Firefox)。

-測試Fail會自動截圖。

-TestCase結束或失敗時會自動關閉Browser。

-測試結果生成HTML集成報告，或是xml的個別報告。

-單一頁面測試案例

-涵蓋多頁面切換的測試案例(ex.LoginTest，從首頁切換到登入頁，登入成功時回到首頁。)。

-會員登入頁驗證碼辨識。

-可讀取csv file參數化生成測試用例。

-Maven集成(封裝完可以推到Jenkins)。

### Future Works

-Test Case的文件整理與自動化測試實作。

-完善大網的單一頁面測試與多頁面的流程測試。

### 終極目標：

-自動化測試框架-”關鍵字”驅動重構。

-導入HttpRunnerManager，自動化測試Interface: https://github.com/HttpRunner/HttpRunnerManager

