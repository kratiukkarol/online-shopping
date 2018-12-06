package com.kratiukkarol.shoppingBackend.dao;

import com.kratiukkarol.shoppingBackend.dto.Address;
import com.kratiukkarol.shoppingBackend.dto.Cart;
import com.kratiukkarol.shoppingBackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	
	// add an address
	boolean addAddress(Address address);
	
	// add a cart
	boolean addCart(Cart cart);
}
