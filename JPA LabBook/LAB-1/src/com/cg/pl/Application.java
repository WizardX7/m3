package com.cg.pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.cg.bean.Author;
import com.cg.service.AuthorServiceImpl;

public class Application {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AuthorServiceImpl service = new AuthorServiceImpl();
		try {
			while(true) {
			
				//Menu 
				System.out.println("---------MENU--------");
				System.out.println("Press 1 for new Author");
				System.out.println("Press 2 for update Author");
				System.out.println("Press 3 for delete Author");
				System.out.println("Press 4 for exit");
				System.out.println("Please enter your choice : ");
				String choice = null;
				choice = br.readLine();
				switch(choice) {
					case "1":
					//Adding Author
						Author author = new Author();
						System.out.println("Enter first name:");
						author.setFirstName(br.readLine());
						System.out.println("Enter middle name:");
						author.setMiddleName(br.readLine());
						System.out.println("Enter last name:");
						author.setLastName(br.readLine());
						System.out.println("Enter phone number:");
						author.setPhoneNo(br.readLine());
						if(service.addAuthor(author)) {
							System.out.println("Author added.......");
						}else {
							System.out.println("Author not added!!!!!");
						}
						break;
					case "2":
					//Updating Author
						System.out.println("Enter author id : ");
						Integer id = Integer.parseInt(br.readLine());
						author = service.findAuthor(id);
						if(author != null) {
							System.out.println("Author exists.....");
							System.out.println(author.toString());
							Author temp = new Author();
							temp.setAuthorId(author.getAuthorId());
							System.out.println("Enter first name:");
							temp.setFirstName(br.readLine());
							System.out.println("Enter middle name:");
							temp.setMiddleName(br.readLine());
							System.out.println("Enter last name:");
							temp.setLastName(br.readLine());
							System.out.println("Enter phone number:");
							temp.setPhoneNo(br.readLine());
							if(service.updateAuthor(temp)!=null) {
								System.out.println("Author updated....");
							}else {
								System.out.println("Cannot be updated!!!!");
							}
						}else {
							System.out.println("Author does not exist!!!!");
						}
						break;
					case "3":
					//Deleting Author
						System.out.println("Enter author id:");
						id = Integer.parseInt(br.readLine());
						if(service.deleteAuthor(id)) {
							System.out.println("Author deleted!!!!");
						}else {
							System.out.println("Author was not deleted!!!");
						}
						break;
					default:
						System.exit(0);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
