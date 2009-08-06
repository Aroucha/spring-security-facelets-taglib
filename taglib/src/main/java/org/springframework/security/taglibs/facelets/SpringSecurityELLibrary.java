package org.springframework.security.taglibs.facelets;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.context.SecurityContextHolder;

import java.util.Set;
import java.util.TreeSet;


/**
 * Taglib to combine the Spring-Security Project with Facelets <br />
 *
 * This is the class responsible holding the logic for making the tags work. <br />
 * The specified <code>public static</code> methods are also defined in the spring-security.taglib.xml
 * to enable them for usage as expression-language element. <br />
 * <br />
 * e.g.<code><br />
 * &lt;ui:component rendered='#{sec:ifAllGranted(&quot;ROLE_USER&quot;)'> blablabal &lt;/ui:component&gt;
 *
 *
 * @author Dominik Dorn - http://www.dominikdorn.com/
 * @date 2009-04-30
 */
public class SpringSecurityELLibrary {

	private static Set<String> parseAuthorities(String grantedRoles) {
		Set<String> parsedAuthorities = new TreeSet<String>();
		if (grantedRoles == null || grantedRoles.isEmpty()) {
			return parsedAuthorities;
		}

		String[] parsedAuthoritiesArr;
		if(grantedRoles.contains(",")){
			parsedAuthoritiesArr = grantedRoles.split(",");
		} else {
			 parsedAuthoritiesArr = new String[]{grantedRoles};
		}

		// adding authorities to set (could pssible be done better!)
		for (String auth : parsedAuthoritiesArr)
			parsedAuthorities.add(auth.trim());
		return parsedAuthorities;
	}

	private static GrantedAuthority[] getUserAuthorities()
	{
		if(SecurityContextHolder.getContext() == null)
		{
			System.out.println("security context is empty, this seems to be a bug/misconfiguration!");
			return new GrantedAuthority[0];
		}
		org.springframework.security.Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		if(currentUser == null)
			return new GrantedAuthority[0];


		GrantedAuthority[] authorities = currentUser.getAuthorities();
		if(authorities == null)
			return new GrantedAuthority[0];

		return authorities;
	}


	/**
	 * Method that checks if the user holds <b>any</b> of the given roles.
	 * Returns <code>true, when the first match is found, <code>false</code> if no match is found and
	 * also <code>false</code> if no roles are given
	 *
	 * @param grantedRoles a comma seperated list of roles
	 * @return true if any of the given roles are granted to the current user, false otherwise
	 */
	public static boolean ifAnyGranted(final String grantedRoles) {
		Set<String> parsedAuthorities = parseAuthorities(grantedRoles);
		if (parsedAuthorities.isEmpty())
			return false;

		GrantedAuthority[] authorities = getUserAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (parsedAuthorities.contains(authority.getAuthority()))
				return true;
		}
		return false;
	}



	/**
	 * Method that checks if the user holds <b>all</b> of the given roles.
	 * Returns <code>true</code>, iff the user holds all roles, <code>false</code> if no roles are given or
	 * the first non-matching role is found
	 *
	 * @param grantedRoles a comma seperated list of roles
	 * @return true if all of the given roles are granted to the current user, false otherwise
	 */
	public static boolean ifAllGranted(final String grantedRoles) {
		Set<String> parsedAuthorities = parseAuthorities(grantedRoles);
		if (parsedAuthorities.isEmpty())
			return false;

		GrantedAuthority[] authorities = getUserAuthorities();
		for (GrantedAuthority authority : authorities) {
			if (!parsedAuthorities.contains(authority.getAuthority()))
				return false;
		}
		return true;


	}

	/**
	 * Method that checks if <b>none</b> of the given roles is hold by the user.
	 * Returns <code>true</code> if no roles are given, or none of the given roles match the users roles.
	 * Returns <code>false</code> on the first matching role.
	 *
	 * @param notGrantedRoles a comma seperated list of roles
	 * @return true if none of the given roles is granted to the current user, false otherwise
	 */
	public static boolean ifNotGranted(final String notGrantedRoles) {
		Set<String> parsedAuthorities = parseAuthorities(notGrantedRoles);
		if (parsedAuthorities.isEmpty())
			return true;

		GrantedAuthority[] authorities = getUserAuthorities();

		for (GrantedAuthority authority : authorities) {
			if (parsedAuthorities.contains(authority.getAuthority()))
				return false;
		}
		return true;
	}


	public SpringSecurityELLibrary() {
	}
}
