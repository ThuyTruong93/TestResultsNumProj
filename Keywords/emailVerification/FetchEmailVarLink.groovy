package emailVerification

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup as Jsoup;

import internal.GlobalVariable

public class FetchEmailVarLink {
	public static check(String host, String storeType, String user,
			String password) {
		try {
			String emailLink = ''
			//create properties field
			Properties properties = new Properties();

			properties.put("mail.imap.host",host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.imap.socketFactory.fallback", "false");
			properties.setProperty("mail.imap.socketFactory.port",String.valueOf(993));
			Session emailSession = Session.getDefaultInstance(properties);

			//create the imap store object and connect with the pop server
			Store store = emailSession.getStore("imap");

			store.connect(host, user, password);

			//create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			MimeMessage[] messages = emailFolder.getMessages();
			//System.out.println("messages.length---" + messages.length);
			int n=messages.length;

			//change n- to number of emails you want to dig through
			for (int i = n-5; i<n; i++) {
				MimeMessage message = messages[i];
				ArrayList<String> links = new ArrayList<String>();

				if(message.getSubject().contains("Verify your email for project") || message.getSubject().contains("Sign in to project")){
					//System.out.println("Subject: " + message.getSubject());
					MimeMultipart messageBody = message.getContent();

					String desc = messageBody.getBodyPart(1).getContent().toString();

					//System.out.println("Description: " + desc);
					Pattern linkPattern = Pattern.compile("href=\"(.*?)\"",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
					Matcher pageMatcher = linkPattern.matcher(desc);
					while(pageMatcher.find()){
						links.add(pageMatcher.group(1));
					}
				}else{
					System.out.println("Email:"+ i + " is not a wanted email");
				}
				for(String temp:links){
					if(temp.contains("emailSubjectHere")){
						emailLink = temp;
						//System.out.println(temp);
					}
				}


			}
			emailLink = Jsoup.parse((emailLink).toString()).text();
			System.out.println(emailLink);
			return emailLink;

			//close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static String getEmailLinkFromEmail(){
		String host = "outlook.office365.com";
		String mailStoreType = "imap";
		String username = "yourEmail";
		String password = "yourPassword";

		String emailLink = check(host, mailStoreType, username, password);
		return emailLink;
	}
}
