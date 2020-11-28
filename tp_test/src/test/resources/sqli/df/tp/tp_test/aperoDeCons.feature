#Author : donovanboisset@gmail.com
Feature: aperoDeCons

Background: 
Given The pub exists

Scenario Outline: aperoDeConsSteps
	Given The pub has <places> places
	And <notFree> places are already taken in the pub
	And A group of <arriving> want to enter the pub
	When the number of arriving + the number of notFree > the number of places is <state>
	Then The status of the pub is <status> 
	And They command <conso> cocktails
	And Le Blanc pays <lbPays> and Pignon <pPays>
	And Pignon feels <pignon>
	

	Examples:
	| places   |  notFree      |  arriving  	|state| status       | conso  | lbPays | pPays |  pignon  |
  |  10      |        9      |   		  2 		|true |"Complet"     |  0     |  0     |  0    | "nothing"|
  |  10      |        8      |        3  		|true |"Complet"	   |  2     |  10    |  10   | "happy"  |
	|  10      |        3      |        2  		|false|"Pas complet" |  4     |  30    |  10   | "sad"    |
	
	
