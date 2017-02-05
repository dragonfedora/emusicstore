package com.emusic.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.emusic.spring.dao.CartDAO;
import com.emusic.spring.dao.ProductDAO;
import com.emusic.spring.model.Cart;
import com.emusic.spring.model.CartItem;
import com.emusic.spring.model.Product;

@Controller
@RequestMapping("/rest/cart")
public class CartController {

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/{cartId}",method=RequestMethod.GET)
	public @ResponseBody Cart readCard(@PathVariable("cartId") String cartId){
		return cartDAO.read(cartId);
	}
	
	@RequestMapping(value="/{cartId}",method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void updateCard(@PathVariable("cartId") String cartId, @RequestBody Cart cart){
		cartDAO.update(cartId, cart);
	}
	
	@RequestMapping(value="/{cartId}",method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteCard(@PathVariable("cartId") String cartId){
		cartDAO.delete(cartId);
	}
	
	/*@RequestMapping(value="/addItem/{productId}",method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addItemInCard(@PathVariable("productId") String productId, HttpServletRequest request){
		String cartId = request.getSession(true).getId();
		Cart cart = cartDAO.read(cartId);
		if(cart == null){
			cart = cartDAO.create(new Cart(cartId));
		}
		
		Product product = productDAO.getProduct(productId);
		
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.addCartItem(new CartItem(product));
		
		cartDAO.update(cartId, cart);
	}
	
	@RequestMapping(value="/removeItem/{productId}",method=RequestMethod.PUT)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeItemInCard(@PathVariable("productId") String productId, HttpServletRequest request){
		String cartId = request.getSession(true).getId();
		Cart cart = cartDAO.read(cartId);
		if(cart == null){
			cartDAO.create(cart);
		}
		
		Product product = productDAO.getProduct(productId);
		
		if(product == null){
			throw new IllegalArgumentException(new Exception());
		}
		
		cart.removeCartItem(new CartItem(product));
		
		cartDAO.update(cartId, cart);
	}*/
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Illegal Access, Please verify your payload")
	public void handleClientErrors(Exception e){
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="Internal Server Error, Pleae verify")
	public void handleServerErros(Exception e){
		
	}
}
