import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://www.cermati.com/gabung')

WebUI.delay(10)

WebUI.click(findTestObject('User - Gabung/buttonNantiSaja'))

WebUI.setText(findTestObject('User - Gabung/inputEmail'), email)

WebUI.setText(findTestObject('User - Gabung/inputPassword'), password)

WebUI.setText(findTestObject('User - Gabung/inputConfirmPassword'), confirmPassword)

WebUI.setText(findTestObject('User - Gabung/inputFirstName'), firstName)

WebUI.setText(findTestObject('User - Gabung/inputLastName'), lastName)

WebUI.setText(findTestObject('User - Gabung/inputMobilePhone'), phone)

WebUI.setText(findTestObject('User - Gabung/inputResidenceCity'), city, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('User - Gabung/listKota', [('text') : city]), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('User - Gabung/listKota', [('text') : city]))
}

if (termsAndCondition == 'no') {
    WebUI.click(findTestObject('User - Gabung/checkboxSyaratDanKetentuan'))
}

WebUI.click(findTestObject('User - Gabung/buttonDaftarAkun'))

if (condition == 'passed') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/notifTerimaKasihSudahBergabung'))
} else if (condition == 'fieldEmpty') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertInputWajibDiisi'))
} else if (condition == 'emailRegistered') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertEmailSudahTerdaftar'))
} else if (condition == 'emailNotValid') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertFormatEmailTidakValid'))
} else if (condition == 'passwordIsNotValid') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertPasswordHarusMemilikiPanjangAntara8-50'))
} else if (condition == 'confirmPasswordIsNotSameAsPass') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertKataSandiTidakSamaDenganKonfirmasiKataSandi'))
} else if (condition == 'nameIsNotValid') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertNamaHanyaDapatDiisiDenganKarakter'))
} else if (condition == 'phoneIsRegistered') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertPhoneIsRegistered'))

    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertTerjadiMasalahKetikaMenghubungkan'))
} else if (condition == 'phoneIsNotValid') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertNomorTeleponTidakValid'))
} else if (condition == 'cityIsNotValid') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertKabupatenKotaTidakTersedia'))
} else if (condition == 'mustBeChecked') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertAndaHarusMenyetujui'))
} else if (condition == 'failedToConnect') {
    WebUI.verifyElementVisible(findTestObject('User - Gabung/AlertTerjadiMasalahKetikaMenghubungkan'))
}

