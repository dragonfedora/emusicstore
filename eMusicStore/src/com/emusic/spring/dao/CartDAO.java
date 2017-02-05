package com.emusic.spring.dao;

import com.emusic.spring.model.Cart;

public interface CartDAO {
	
	Cart create(Cart card);
	
	void delete(String cartId);
	
	void update(String cartId, Cart cart);
	
	Cart read(String cartId);
	
}
