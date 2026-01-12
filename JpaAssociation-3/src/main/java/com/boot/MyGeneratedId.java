package com.boot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGeneratedId implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix ="MYID:-";
		int id =Math.abs(new Random().nextInt());
		String dte =new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
		return prefix+dte+" "+id;
	}

}
