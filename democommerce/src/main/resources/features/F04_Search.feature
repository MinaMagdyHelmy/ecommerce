Feature: user could use search functionality

  Scenario Outline: user search with valid product name
    Given test step "<productName>"


    Examples:
    |productName|
   | book |
 | phone |
   | shoes |

    Scenario Outline: user search with valid sku
      Given sku step "<sku>"
      Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|