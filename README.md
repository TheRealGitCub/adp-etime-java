# ADP eTime API for Java
[**Documentation**](https://therealgitcub.github.io/adp-etime-java/)

Connect to and interact with your ADP eTime Timecard from Java! Simulates user 
entry through page scraping techniques. 

**Currently supports:**
* Login with username and password
* Clock In/Out
* Get current timecard (as an Object)

**Features planned:**
* Approve timecard
* Get current timecard (as JSON)
* Get past timecards
* Adapt for any pay type (bi-weekly, monthly, etc.)

## Configuration
ADP eTime API may have to be configured for your company's preferred eTime server. 
This can be done in Etime.java under the `ADP_DOMAIN` constant. Because it was 
written with my own company in mind, it may not work with all configurations.

## Dependencies
* [jhy/jsoup](https://github.com/jhy/jsoup/)
* [google/gson](https://github.com/google/gson)

## Disclaimer
ADP and Enterprise eTime are registered trademarks of ADP, LLC. ADP eTime 
API and Kobi Tate (TheRealGitCub) are NOT affiliated with ADP, LLC. This 
software is NOT associated with nor endorsed by ADP, LLC. Use of this API 
may violate ADP eTime terms and conditions. Developer assumes no 
responsibility for any repercussions from the use of the software. 
Use at your own risk.
