package sesion11.dom.product;


import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


public class TestJAXB {
	public static void main(String[] args) throws Exception {
		JAXBContext ctx=JAXBContext.newInstance("sesion11.dom.product");
		Unmarshaller um=ctx.createUnmarshaller();
		Productlist products=
				(Productlist)um.unmarshal(new File("xml/products.xml"));
		List<Product>lst=products.getProduct();
		for(Product p:lst){
			System.out.println(p.getId()+"\t"+p.getName());
		}
	}
}
