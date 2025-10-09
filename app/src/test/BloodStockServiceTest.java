//package test;
//
//import model.BloodStock;
//import service.BloodStockService;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.util.List;
//
//public class BloodStockServiceTest {
//    private BloodStockService bloodStockService;
//
//    @BeforeEach
//    public void setUp() {
//        bloodStockService = new BloodStockService();
//    }
//
//    @Test
//    public void testAddAndGetAllBloodStock() throws SQLException {
//        BloodStock stock = new BloodStock(0, 1, "A+", 5, new Date(System.currentTimeMillis()));
//        bloodStockService.addBloodStock(stock);
//        List<BloodStock> stocks = bloodStockService.getAllBloodStock();
//        Assertions.assertTrue(stocks.size() > 0);
//    }
//}
//
