package controller.server;

import java.io.Serializable;

import Lab.ItemProduct;

public class ItemNameValidate {

	public String validateItemName(ItemProduct item)
	{
		
		String result = "Valid Name. ", name = item.getName();
		
		for(int i=0; i<name.length();i++)
		{
		    
			char ch = name.charAt(i);
		    
			if (!(Character.isLetter(ch) || ch == ' ') )
			{
				
				result="invalid ";
				
		    }
		
		}
		return result;	
	

	}
}
