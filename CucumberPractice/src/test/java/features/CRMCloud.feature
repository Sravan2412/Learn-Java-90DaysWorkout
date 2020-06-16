Feature: CRMCloud
 
Scenario Outline: Creating a Lead in CRMCloud
 
 
Given Go to https://demo.crmcloud.com
And Give username as <uName> and password as <pwd>
And Choose theme as Claro Theme
And Go to Sales and Marketing and click Sales Home
And Click Create contact
And Select Title and type First name as <fName>, Last Name as <lName>, Email as <Email> and Phone Numbers as <phNum>
And Select Lead Source as Public Relations and Business Roles as CEO
And Fill the Primary Address as <addrs>, City as <city>, State as <state>, Country as <country> and Postal Code as <pCode> and click Save
And Click Create in Leads section
And Fill First name as <fName1> & Last name as <lName1> , Status as In Process, Title as <title> and Department as <dept>
And Select Lead as Public Relations and fill Email as <Email1> and Phone Number as <phNum1>
And Click Save and View
And Mouse over on Today's Activities and click Meetings
And Click Create and Type Subject as <subject> and Time as tomorrow 3 p.m
And Click Add paricipants, add your created Lead name as <name> and click Save
When Click contacts under Sales and Marketing, search the lead Name and click the name from the result
Then Check whether the Meeting is assigned to the contact.

Examples:

|uName|pwd|fName|lName|Email|phNum|addrs|city|state|country|pCode|fName1|lName1|title|dept|Email1|phNum1|subject|name|
|admin|admin|Sundar|Pichai|sundarpichai@gmail.com|9884346186|Vivekanandhar Street|Chennai|TamilNadu|India|600099|Sundar|Pichai|Manager|Sales|sundarpichai@gmail.com|9841054321|Project Status as Planned|sundar pichai|