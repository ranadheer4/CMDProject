package com.cmd.Workflow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cps.ObjectRepository.Cmd_DeleteNote_Task;
import com.cps.genericUtility.BaseClass;
import com.cps.genericUtility.IConstants;

public class Sample extends BaseClass {
	static {
		System.setProperty(IConstants.chromeKey,IConstants.chromeValue);
	}
   @Test(
      groups = {"SmokeTest"}
   )
   public void deleteNotetask() throws InterruptedException {
      Cmd_DeleteNote_Task d = new Cmd_DeleteNote_Task(driver);
      d.mouseMover(driver);
//      List<WebElement> rc = driver.findElements(By.xpath("//datatable-body[@role='rowgroup']/descendant::datatable-body-row"));
//      System.out.println(rc.size());
//      List<WebElement>cc=driver.findElements(By.xpath("//datatable-body[@role='rowgroup']/descendant::datatable-body-row/descendant::datatable-body-cell"));
//      System.out.println(cc.size());
     
      String textToMatch = "Jul 11,2023 ";
 
  // Find all rows in the table
  java.util.List<WebElement> rows = driver.findElements(By.xpath("//datatable-body[@role='rowgroup']/descendant::datatable-body-row"));
  System.out.println(rows.size());
  for (WebElement row : rows) {
      // Find all cells in the current row
      java.util.List<WebElement> cells = row.findElements(By.xpath("//descendant::datatable-body-cell"));
      System.out.println(cells.size());
      // Assuming the 1st column is represented by the first cell (index 0) in each row
      WebElement cellInFirstColumn = cells.get(0);
      String actualText = cellInFirstColumn.getText();

      if (actualText.equals(textToMatch)) {
          // Assuming the link in the corresponding cell is represented by a <a> tag
          WebElement linkInCell = cells.get(2).findElement(By.tagName("div"));
          linkInCell.click();
          break; // Stop searching once we find the matching row
      }
  }
}
}