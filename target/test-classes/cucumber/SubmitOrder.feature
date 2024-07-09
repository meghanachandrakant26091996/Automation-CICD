
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER>" message is displayed on ConfirmationPage

    Examples: 
      | name  | password | productName  |
      | meghanachandrakant.26@gmail.com | Meghsch@nd1 | ZARA COAT 3 |

