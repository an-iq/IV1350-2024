/* package com.example.POS_System.view;

import com.example.POS_System.observer.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements SaleObserver {
    private static final String FILE_NAME = "total-revenue.txt";
    private double totalRevenue;

    @Override
    public void update(double totalRevenue) {
        this.totalRevenue = totalRevenue;
        printTotalRevenueToFile();
    }

    private void printTotalRevenueToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("Total Revenue: " + totalRevenue);
            System.out.println("Total Revenue written to file: " + totalRevenue); // Confirmation message
        } catch (IOException e) {
            System.err.println("Failed to write total revenue to file: " + e.getMessage());
        }
    }
}
 */
 
/* 
 package com.example.POS_System.view;

import com.example.POS_System.observer.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TotalRevenueFileOutput implements SaleObserver {
    private static final String FILE_NAME = "total-revenue.txt";
    private double totalRevenue;

    @Override
    public void update(double totalRevenue) {
        this.totalRevenue = totalRevenue;
        printTotalRevenueToFile();
    }

    private void printTotalRevenueToFile() {
        System.out.println("Attempting to write total revenue to file: " + FILE_NAME); // Debug message
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println("Total Revenue: " + totalRevenue);
            System.out.println("Total Revenue written to file: " + totalRevenue); // Confirmation message
        } catch (IOException e) {
            System.err.println("Failed to write total revenue to file: " + e.getMessage());
        }
    }
}  */


/* // Package declarations.
package com.example.POS_System.view;
// Import declarations.
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import com.example.POS_System.observer.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver
{
    
    float totalIncome;
    private static final String REVENUELOG_FILE_NAME = "total_revenue.txt";
    private PrintWriter logger;

    /**
     * Constructor creating a new instance of TotalRevenueFileOutput().
     * @throws IOException If an I/O error occurs.
     */
 /*    public TotalRevenueFileOutput () throws IOException
    {
        this.totalIncome = 0.0f;

        logger = new PrintWriter(new FileWriter(REVENUELOG_FILE_NAME), true);
    }

    @Override
    public void update(double totalRevenue)
    {
        totalIncome += totalRevenue;

        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(currentTime() + " → The total revenue after the current transaction is: €" + totalIncome + '\n');
        logMsgBuilder.append("___________________________________________________________________");
        logger.println(logMsgBuilder);
    }

    /**
     * Returns the current time as a string.
     * @return A string containing the current time.
     */
  /*   private String currentTime()
    {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return current.format(formatter);
    }

  
}  */

package com.example.POS_System.view;

import com.example.POS_System.observer.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TotalRevenueFileOutput implements SaleObserver {
    private float totalIncome;
    private static final String REVENUELOG_FILE_NAME = "total_revenue.txt";
    private PrintWriter logger;

    
     //* Constructor creating a new instance of TotalRevenueFileOutput().
     //* @throws IOException If an I/O error occurs.
     
     public TotalRevenueFileOutput() throws IOException {
        this.totalIncome = 0.0f;
        // Ensure FileWriter is in append mode
        try {
            logger = new PrintWriter(new FileWriter(REVENUELOG_FILE_NAME, true), true);
            System.out.println("Debug: TotalRevenueFileOutput initialized, logging to " + REVENUELOG_FILE_NAME);
        } catch (IOException e) {
            System.err.println("Debug: Failed to initialize PrintWriter: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(double totalRevenue) {
        System.out.println("Debug: Entering update method with totalRevenue: " + totalRevenue); // Debug message
        totalIncome += totalRevenue;

        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(currentTime() + " → The total revenue after the current transaction is: €" + totalIncome + '\n');
        logMsgBuilder.append("___________________________________________________________________");

        System.out.println("Debug: Preparing to write to file: " + logMsgBuilder); // Debug message before writing
        try {
            logger.println(logMsgBuilder.toString());
            logger.flush();  // Ensure data is flushed to the file
            System.out.println("Debug: Successfully written to file: " + logMsgBuilder);  // Confirmation message
        } catch (Exception e) {
            System.err.println("Debug: Error writing to file: " + e.getMessage());
        }
    }

    
    // * Returns the current time as a string.
    // * @return A string containing the current time.
    
     private String currentTime() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return current.format(formatter);
    }
} 

