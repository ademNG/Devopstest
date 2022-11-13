/*package tn.esprit.rh.achat;



import static org.junit.Assert.*;


import java.text.ParseException;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;



@RunWith(SpringRunner.class)
@SpringBootTest

public class StockServiceTest {
	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddStock()throws ParseException{
		List<Stock> stocks=stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s=new Stock(null, expected, expected);
		
		s.setLibelleStock("test");
		s.setQte(10);
		s.setQteMin(100);
	   stockService.addStock(s);
		assertEquals(expected+1,stockService.retrieveAllStocks().size());
		}
	
	@Test 
	public void testDeleteStock()throws ParseException{
		
        Stock s=new Stock(null, null, null);
		
		s.setLibelleStock("test");
		s.setQte(10);
		s.setQteMin(100);
		stockService.addStock(s);
		stockService.deleteStock(s.getIdStock());
		assertNull(stockService.retrieveStock(s.getIdStock()));
	}
	
	
	@Test 
	public void testRetrieveAllStock() throws ParseException{
		
		List<Stock> stocks=stockService.retrieveAllStocks();
		int expected =stocks.size();
		 Stock s=new Stock(null, expected, expected);
			
			s.setLibelleStock("test");
			s.setQte(10);
			s.setQteMin(100);
			stockService.addStock(s);
		assertEquals(expected+1,stockService.retrieveAllStocks().size());
		stockService.deleteStock(s.getIdStock());
				
	}
	

	
	

}
*/
