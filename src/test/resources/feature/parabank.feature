@ParaBank
  Feature: para bank test
    Scenario: para bank test all site
      Given user goes to site
      And user click register button
      And user write personal information
      And user click register button
      And user click open new account button and create account
      And user click Transfer fund and transfer money from first account to another account
      And user click bill pay and enter payee information
      And user click find transactions
      Then user click request load and write amount