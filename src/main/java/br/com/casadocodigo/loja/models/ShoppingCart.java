package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart implements Serializable{
	
	private static final long serialVersionUID = 7850305149527655083L;
	
	private Map<ShoppingItem, Integer> items = new LinkedHashMap<ShoppingItem, Integer>();
	
	public void add(ShoppingItem item){
		items.put(item, getQuantity(item) + 1);
	}
	
	public Integer getQuantity(ShoppingItem item){
		if(!items.containsKey(item)){
			items.put(item, 0);
		}
		
		return items.get(item);
	}
	
	public Integer getQuantity(){
		return items.values().stream().reduce(0, (next, accumulator) -> next + accumulator);
	}
	
	public Collection<ShoppingItem> getList(){
		return new ArrayList<>(items.keySet());
	}
	
	public BigDecimal getTotal(ShoppingItem item){
		return item.getTotal(getQuantity(item));
	}
	
	public BigDecimal getTotal(ShoppingItem item){
		BigDecimal total = BigDecimal.ZERO;
		
		for(ShoppingItem item : items.keySet()){
			total = total.add(getTotal(item));
		}
		
		return total;
	}
	
	public void remove (ShoppingItem shoppingItem){
		items.remove(shoppingItem)
	}
	
	public boolean isEmpty(){
		return items.isEmpty();
	}

}
