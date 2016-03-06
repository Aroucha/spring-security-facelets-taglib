JSF 2.0 / Facelets Taglibs are different than JSP-Taglibs. To use Spring Security with Facelets / JSF 2.0, one has to use a special taglib... one that is provided here.

Currently, our Homepage is located at http://www.dominikdorn.com/facelets/ while our code and bugtracking is here on google-code.

**JOIN OUR GOOGLE GROUP TODAY TO STAY INFORMED OF NEW RELEASES**

<h2>Buy me a drink</h2>
If you find this Tag-Library useful, you may consider buying me a drink.
As you probably don't live in Vienna, you could do that via PayPal.

<a href='https://www.paypal.com/cgi-bin/webscr?cmd=_xclick&business=dominik.dorn@gmail.com&currency_code=EUR&amount=5&return=&item_name=Buy+me+a+drink'><img src='http://www.blogclout.com/blog/wp-content/plugins/buy-me-beer/icon_beer.gif' align='left' border='0' alt='Buy me a drink (or two ;) )' />Buy me a Drink</a>
(You may as well change the price field :) )

<h2>New Version 0.5 available</h2>
As of 2010-09-25 version 0.5 is available.

We've fixed issues with Java 5 and now also support Springs OSGI solution (Spring DM Server) by providing appropriate manifest files.

Add our maven repo to your pom (or you mavens settings.xml):

<h3>Maven Repository</h3>

> 

&lt;repository&gt;


> > 

&lt;id&gt;

org.springframework.security.taglibs.facelets

&lt;/id&gt;


> > 

&lt;url&gt;

http://spring-security-facelets-taglib.googlecode.com/svn/repo/

&lt;/url&gt;



> 

&lt;/repository&gt;



<h3>Maven: JSF 1.2 (Facelets) & Spring 2</h3>
Add this dependency to your pom's dependency section:



&lt;dependency&gt;


> 

&lt;groupId&gt;

org.springframework.security

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

facelets-taglib-jsf12-spring-2

&lt;/artifactId&gt;


> 

&lt;version&gt;

0.5

&lt;/version&gt;




&lt;/dependency&gt;



<h3>Maven: JSF 1.2 (Facelets) & Spring 3</h3>
Add this dependency to your pom's dependency section:



&lt;dependency&gt;


> 

&lt;groupId&gt;

org.springframework.security

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

facelets-taglib-jsf12-spring-3

&lt;/artifactId&gt;


> 

&lt;version&gt;

0.5

&lt;/version&gt;




&lt;/dependency&gt;



<h3>Maven: JSF 2.0 & Spring 2</h3>
Add this dependency to your pom's dependency section:



&lt;dependency&gt;


> 

&lt;groupId&gt;

org.springframework.security

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

facelets-taglib-jsf20-spring-2

&lt;/artifactId&gt;


> 

&lt;version&gt;

0.5

&lt;/version&gt;




&lt;/dependency&gt;



<h3>Maven: JSF 2.0 & Spring 3</h3>
Add this dependency to your pom's dependency section:



&lt;dependency&gt;


> 

&lt;groupId&gt;

org.springframework.security

&lt;/groupId&gt;


> 

&lt;artifactId&gt;

facelets-taglib-jsf20-spring-3

&lt;/artifactId&gt;


> 

&lt;version&gt;

0.5

&lt;/version&gt;




&lt;/dependency&gt;




<h2>Manual Downloads</h2>
<p>See the download section. You will need the taglib-core-0.4.jar AND the corresponding jar for your environment (Spring 2/3, JSF 1.2/2.0)<br>
</p>

<h2>Example Webapps</h2>

Examples Web-Applications showing how to work with the taglibs with a working
setup for a Jetty server are provided in the Subversion repository.