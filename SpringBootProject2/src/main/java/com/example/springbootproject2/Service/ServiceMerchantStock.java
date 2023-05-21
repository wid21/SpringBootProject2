package com.example.springbootproject2.Service;


import com.example.springbootproject2.Model.Merchant;
import com.example.springbootproject2.Model.MerchantStock;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class ServiceMerchantStock {

    ArrayList<MerchantStock> stocks = new ArrayList<>();

    public ArrayList<MerchantStock> getStocks() {
        return stocks;
    }

    public void addStocks(MerchantStock merchantStock) {
        stocks.add(merchantStock);
    }

    public boolean updateStocks(@PathVariable int id, @Valid @RequestBody MerchantStock merchantStock) {

        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getId() == id) {
                stocks.set(i, merchantStock);
                return true;

            }
        }
        return false;

    }

    public boolean deleteStocks(@PathVariable int id) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getId() == id) {
                stocks.remove(i);
                return true;

            }
        }
        return false;
    }

    //add product to a merchantStock
    public boolean  addProductToMerchantStock(int productid, int merchantid, int stock) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getMerchantId() == merchantid) {
                if (stocks.get(i).getProductid() == productid) {
                    if (stock >= 0) {
                        stocks.get(i).setStock(stocks.get(i).getStock() + stock);
                        return true;
                    }}}
        }
        return false;
    }

    //search for stock by given productid merchantid)
    public int searchStockid(int productid, int merchantid) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getId() == productid) {
                if (stocks.get(i).getId() == merchantid) {
                    return i;
                }
            }
        }
            return 0;

        }

    //ckeck for stock by given  productid merchantid)
    public boolean isStock(int productid, int merchantid) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getId() == productid) {
                if (stocks.get(i).getId() == merchantid) {
                    if (stocks.get(i).getStock()> 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //reduce foe stock after find the stock
    public boolean reducStock(int productid, int merchantid) {
        for (int i = 0; i < stocks.size(); i++) {
            if (stocks.get(i).getId() == productid) {
                if (stocks.get(i).getId() == merchantid) {
                    if (stocks.get(i).getStock()> 0) {
                        stocks.get(i).setStock(stocks.get(i).getStock() - 1);
                        return true;
                    } } } }
        return false;

    }
    }
