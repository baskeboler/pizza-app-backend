package com.pizza.models.helpers;

import unquietcode.tools.flapi.Descriptor;
import unquietcode.tools.flapi.DescriptorMaker;
import unquietcode.tools.flapi.Flapi;

public class ClienteBuilderDescriptorMaker implements DescriptorMaker {

	@Override
	public Descriptor descriptor() {
		// TODO Auto-generated method stub
		return Flapi.create(AnnotatedClienteHelper.class)
				.setPackage("com.pizza.models.builders")
				.setStartingMethodName("builder").build();
	}

}
