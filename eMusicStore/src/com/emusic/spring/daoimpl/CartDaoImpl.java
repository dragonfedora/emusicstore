package com.emusic.spring.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.emusic.spring.dao.CartDAO;
import com.emusic.spring.model.Cart;

@Repository
public class CartDaoImpl implements CartDAO {

	private Map<String, Cart> listCarts;
	
	public CartDaoImpl() {
		listCarts = new HashMap<String, Cart>();
	}

	@Override
	public Cart create(Cart cart) {
		if (listCarts.containsKey(cart.getCartId())) {
			throw new IllegalArgumentException(String.format("Can't create cart as it already avilable"));
		}

		listCarts.put(cart.getCartId(), cart);
		return cart;
	}

	@Override
	public void delete(String cartId) {
		if (!listCarts.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Card doesn't exist for given ID " + cartId));
		}

		listCarts.remove(cartId);

	}

	@Override
	public void update(String cartId, Cart cart) {
		if (!listCarts.containsKey(cartId)) {
			throw new IllegalArgumentException(String.format("Card doesn't exist for given ID " + cartId));
		}

		listCarts.put(cartId, cart);
	}

	@Override
	public Cart read(String cartId) {

		return listCarts.get(cartId);
	}

}
