package ava.task1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Bank bank = new Bank();
        Document doc = DocumentBuilderFactory
                            .newInstance()
                            .newDocumentBuilder()
                            .parse("java-se-07/src/main/java/ava/task1/bank.xml");
        doc.getDocumentElement().normalize();
        NodeList rawAccounts = doc.getElementsByTagName("account");
        for (int i = 0; i < rawAccounts.getLength(); i++) {
            Element rawAccount = (Element) rawAccounts.item(i);
            bank.addAccount(new Account(Integer.parseInt(rawAccount.getElementsByTagName("id").item(0).getTextContent()),
                                        rawAccount.getElementsByTagName("holder").item(0).getTextContent(),
                                        new BigDecimal(rawAccount.getElementsByTagName("initial-money").item(0).getTextContent())));
        }
        NodeList rawTransfers = doc.getElementsByTagName("transfer");
        for (int i = 0; i < rawTransfers.getLength(); i++) {
            Element rawTransfer = (Element) rawTransfers.item(i);
            int senderId = Integer.parseInt(rawTransfer.getElementsByTagName("acc-id-sender").item(0).getTextContent());
            int recipientId = Integer.parseInt(rawTransfer.getElementsByTagName("acc-id-recipient").item(0).getTextContent());
            BigDecimal money = new BigDecimal(rawTransfer.getElementsByTagName("money").item(0).getTextContent());
            bank.addTransaction(new Transaction(bank.getAccountById(senderId), bank.getAccountById(recipientId), money));
        }
        bank.printAccounts();
        bank.executeTransactions();
        System.out.println("_______");
        bank.printAccounts();
    }
}
