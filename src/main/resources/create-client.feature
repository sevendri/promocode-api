Feature: Create Client

  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL

    Given user wants to create a client with the following attributes
      | clientId  | address       | cnpj               | email       | mobile      | name       | registerDate |
      | 1         | rua abc, 1000 | 12.345.678/0001-12 | abc@abc.com | 99999-8888  | empresa sa | 2020-05-20   |

    When user saves the new cliente 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'