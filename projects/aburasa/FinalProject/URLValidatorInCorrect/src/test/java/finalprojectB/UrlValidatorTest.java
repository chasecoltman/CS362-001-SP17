/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	   System.out.println(urlVal.isValid("http://amazon.com"));
	   System.out.println(urlVal.isValid("not://a.website.com"));
	   System.out.println(urlVal.isValid("http://www.google.com"));
	   System.out.println(urlVal.isValid("htp::///www.google.com"));
	   System.out.println(urlVal.isValid("http://wwe.google.com.com"));
	   System.out.println(urlVal.isValid("http:w/w/w.google//.com"));
	   System.out.println(urlVal.isValid("https://www.google.com/search?q=Fake+News"));
	   System.out.println(urlVal.isValid("http://www.bbc.co.uk"));
	   System.out.println(urlVal.isValid("https://www.google.com:4000"));
	   System.out.println(urlVal.isValid("http://cbc.ca"));
	   System.out.println(urlVal.isValid("mailto:coltmanc@oregonstate.edu"));
	   System.out.println(urlVal.isValid("192.0.0.1"));
	   System.out.println(urlVal.isValid("http://255.255.255.355"));
	   System.out.println(urlVal.isValid("mailto:fakenewsemail"));
	   System.out.println(urlVal.isValid("ftp://fakenews.oregonstate.edu"));
   }

   public void testYourFirstPartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       System.out.println(urlVal.isValid("http://google.com"));
       System.out.println(urlVal.isValid("http://google.com:80"));
       System.out.println(urlVal.isValid("http://yahoo.com"));
   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       System.out.println(urlVal.isValid("http:/google.com"));
       System.out.println(urlVal.isValid("http://google/com"));
       System.out.println(urlVal.isValid("http://google.bad"));
       System.out.println(urlVal.isValid("://google.com"));
       System.out.println(urlVal.isValid("google..com"));
       System.out.println(urlVal.isValid("https://google.www.com"));

   }

   public void testYourThirdPartition(){
       UrlValidator urlVal = new UrlValidator(null,null,UrlValidator.ALLOW_ALL_SCHEMES);
       System.out.println(urlVal.isValid("google.com"));
       System.out.println(urlVal.isValid("yahoo.com"));
       System.out.println(urlVal.isValid("google"));
       System.out.println(urlVal.isValid("yahoo"));
       System.out.println(urlVal.isValid("www.yahoo"));
       System.out.println(urlVal.isValid("https://google"));
       System.out.println(urlVal.isValid("http://80"));
   }

   ResultPair[] testUrlAuth = {
            new ResultPair("www.google.com", true),
            new ResultPair("0.0.0.0", true),
            new ResultPair("255.255.255.255", true),

            //appears to be bug
            new ResultPair("256.256.256.256", false),
            new ResultPair("1.2.3.4.5", false),
            new ResultPair("1.2.3.4.", false),
            new ResultPair("1.2.3", false),
            new ResultPair(".1.2.3.4", false),
            new ResultPair("aaa.", false),
            new ResultPair(".aaa", false),
            new ResultPair("aaa", false),
            new ResultPair("", false)
   };
   ResultPair[] testUrlQuery = {
            //throws error
            new ResultPair("?action=view", true),
            //throws error
            new ResultPair("?action=edit&mode=up", true),
            new ResultPair("?action=edit/mode=up", false),
            new ResultPair("??==?", false),
            new ResultPair("", true)
    };
   ResultPair[] testPath = {
            new ResultPair("/test1", true),
            new ResultPair("/t123", true),
            new ResultPair("/$23", true),
            new ResultPair("/..", false),
            new ResultPair("/../", false),
            new ResultPair("/test../", false),
            new ResultPair("/../../", false),
            new ResultPair("/test1/", true),
            new ResultPair("", true),
            new ResultPair("/test1/file", true),
            new ResultPair("/..//file", false),
            new ResultPair("/test1//file", false)
   };

    public void testURLQueries(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String url = "http://www.google.com/path";
        String URLtest;
        assertTrue(urlVal.isValid(url));
        for(int i =0; i < testUrlQuery.length; i++){
            URLtest = url + testUrlQuery[i].item;
            //System.out.println(URLTest);
            if(urlVal.isValid(URLtest) == testUrlQuery[i].valid){
                System.out.println("Confirmed Query");
            }
            else{
                System.out.println("Test Failed Query: Error!!!");
            }
        }
    }

    public void testURLPathways(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String URLString = "http://google.com";
        String URLtest;
        assertTrue(urlVal.isValid(URLString));

        for(int i = 0; i < testPath.length; i++){
            URLtest = URLString + testPath[i].item;
            //System.out.println(URLtest);
            if(urlVal.isValid(URLtest) == testUrlQuery[i].valid){
                System.out.println("Confirmed Path");
            }
            else{
                System.out.println("Test Failed Pathways: Error!!!");
            }
        }
    }

    public void testURLAuth(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String URLString = "http://google.com";
        String baseTest = "http://google.com:30/test";
        String partUrl = "http://";
        String partEnd = ":30/test";
        String URLtest;
        assertTrue(urlVal.isValid(baseTest));
        for(int i = 0;i<testUrlAuth.length;i++)
        {
            //Put together URL for test
            URLtest = partUrl + testUrlAuth[i].item + partEnd;
            System.out.println(URLtest);

            //Output success or failure
            if(urlVal.isValid(URLtest) == testUrlAuth[i].valid){
                System.out.println("Confirmed Auth");
            }
            else{
                System.out.println("Test Failed Authority: Error!!!");
            }
        }

    }
}
