# -E29MicroService


I added a backup file for my database named it 'productDB.sql'

Heres the process on how to restore database on postgres using a backup file //https://www.youtube.com/watch?v=GWx0Xw2A8AA

also in my application.propertie files our credentials on postgres may be different so please change those credentials on my application.property files


1.What are the functionalities involved, and the microservices you've created

--User--
createUser = add user to database 

updateUser = change/update info about an existing user

findUser  = find a user by id 

deleteUser = delete a user in database, it calls the productDeleteAll or checkOutDeleteAll depending on the user role so that associate products/cart items 
              associated with user will also be deleted

--Product--
addProduct = check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
             if the user exist then the product is added to the database
             
updateProductBySeller = check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
             if the user exist then the product selected will be updated
             
getProductById = gets a product with the specific product 

getProductByIdByUserId =  check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
              then returns a product with a specific product id associated with the UserId
              
updateProductByCart = this method updates a product, it is called by the Cart microservice when a product is either added or updated from the cart

deleteProductById = check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
               then deletes a product with specific product id associated with the UserId
 
 getAllProduct = check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
                then returns all product associated with given userId
 
 deleteAllProduct  = check if the user exist in the database and has a role of seller, this is done by calling the findUser endpoint from the User microservice
                then deletes all product associated with the given userId, this method is called when a user id deleted
                
 --Cart--
 addToCart = check if the user exist in the database and has a role of customer, this is done by calling the findUser endpoint from the User microservice
             then check if the product exist in the database then add the item to cart, then this will call updateProductByCart method in product repository to
             update the product quantity in the database
             
 updateCheckout = updates an item on the checkOut database this will call updateProductByCart method in product repository to
             update the product quantity in the database, if the quantiy of an item in the CheckOut database is uodated to 0 it will then be deleted and the quantity
             of the product on the product database will also be updated accordingly
 
 getAllCheckOut = check if the user exist in the database and has a role of customer, this is done by calling the findUser endpoint from the User microservice 
            then gets all checkOut items in the cart associated with the given userId
  
  deleteAllInCart check if the user exist in the database and has a role of customer, this is done by calling the findUser endpoint from the User microservice 
            then delete all items associated with that userId
                
----------------------------------------------------------------------------------------------------------------------------------------------------------------

2.Why do you think that the functionality needs to be isolated from another service?

I think functions are needed to be isolated from another service because it makes the process less chaotic,
it becomes easier to work on things because you can focus on smaller things without diving too deep to the bigger picture of the program,
debugging is also become easier, incorrect logic can be easily spotted since it becomes narrower by dividing it into separate services
               
               
    






