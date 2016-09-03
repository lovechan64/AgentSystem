package org.agent.service.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.agent.pojo.Contacts;
import org.agent.pojo.Customs;
import org.agent.pojo.User;
import org.agent.service.contacts.ContactsService;
import org.agent.service.customs.CustomsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

	@Test
	public void test() {
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-a.xml");
		 CustomsService userService=ctx.getBean("customsService",CustomsService.class);
		 ContactsService contactsService=ctx.getBean("contactsService",ContactsService.class);
			
		
		 Contacts	contactss=new Contacts();
		 Customs custom=new 	Customs();
			custom.setId(1);
		contactss.setCustomId(custom.getId());
	List<Contacts>	contactsList=contactsService.getContactsList(contactss);
	
	 custom= userService.getCustomsById(custom);
		
		
		
		Customs user=new Customs();
		 user.setRegDatetime(new Date());
 user.setAgentId(1);
 user.setAgentCode("asdasd");
 
List<Contacts> contactList=new ArrayList<Contacts>();
Contacts contacts=new Contacts();
contacts.setContactEmail("ss");
contacts.setCustomId(1);
contactList.add(contacts);
userService.tx_addCustomContact(user, contactList);
		
		

for (Contacts ccc:contactsList ) {
	System.out.println(ccc.getContactName()+"======================getContactName"+custom.getAgentName());
}

	}

}
