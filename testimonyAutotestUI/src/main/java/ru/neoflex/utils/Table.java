package ru.neoflex.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class Table {
    private WebElement tableElement;
    private WebDriver driver;

    public Table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }
    public List<WebElement> getRows() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(1);
        return rows;
    }
    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }
    public String getValueFromCell (int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber).get(columnNumber);
        return cell.getText();
    }
}
//getRows() - получение всех строк из таблицы и удаление строки с заголовками
//getRowsWithColumns() - разбиение строк на колонки
//getValueFromCell - вычитывание содержимого ячейки по номеру строки и столбца