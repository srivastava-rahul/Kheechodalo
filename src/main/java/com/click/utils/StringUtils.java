package com.click.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author parveen
 */
public class StringUtils {

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,15})";

	/*
	 * Check whether input string is null or not, if input string is null, then return empty string.
	 * @param s Input String
	 * @return s String
	 */
	public static String checkString(String s) {
		if (s == null) {
			return "";
		}
		if (s.toLowerCase().contains("<script>")||s.toLowerCase().contains("<?>")||s.toLowerCase().contains("<*>")||
				s.toLowerCase().contains("</script>")||s.toLowerCase().contains("<>")) {
			System.out.println(" s :"+ s);
			throw new NullPointerException("Invalid Data");
		}
		return s.trim();
	}

	public static boolean isBlank(String s) {
		return org.apache.commons.lang.StringUtils.isBlank(s);
	}

	public static boolean isNotBlank(String s) {
		return org.apache.commons.lang.StringUtils.isNotBlank(s);
	}

	public static String pad(String str, int size, char padChar) {
		if (str == null)
			str = "";
		// return String.format("%1$-" + size + "s", str);
		StringBuffer padded = new StringBuffer(str.trim());
		while (padded.length() < size) {
			padded.append(padChar);
		}
		return padded.toString();
	}

	public static String lpad(String str, int size, char padChar) {
		if (str == null)
			str = "";
		// return String.format("%1$-" + size + "s", str);
		StringBuffer padded = new StringBuffer(str.trim());
		while (padded.length() < size) {
			padded.insert(0, padChar);
		}
		return padded.toString();
	}

	public static boolean isValidEmail(String email) {

		Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+;");
		Matcher matcher = pattern.matcher(email);
		boolean matchFound = matcher.matches();
		if (matchFound) {
			pattern = Pattern.compile(".+@.+\\.[a-z]+");
			String[] splitStr = email.split(";");
			for (String str : splitStr) {
				matcher = pattern.matcher(str);
				if (!matcher.matches())
					return false;
			}
		} else
			return false;

		return true;
	}

	public static boolean isValidAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isUrlValidate(String url) {

		String urlPattern = "\\b(https?://|ftp://|www.)" + "[-A-Za-z0-9+&@#/%?=~_|!:,.;]" + "*[-A-Za-z0-9+&@#/%=~_|]";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(urlPattern);
		java.util.regex.Matcher m = p.matcher(url);
		return m.matches();
	}

	public static String removeChar(String originalString, char c) {
		String newString = "";
		originalString = checkString(originalString);
		if (originalString.indexOf(c) != -1) {
			for (int i = 0; i < originalString.length(); i++) {
				if (originalString.charAt(i) != c)
					newString += originalString.charAt(i);
			}
		} else {
			return originalString;
		}
		return newString;
	}

	public static String replaceChar(String originalString, char oldChar, char newChar) {
		originalString = checkString(originalString);
		if (originalString.indexOf(oldChar) != -1) {
			originalString = originalString.replace(oldChar, newChar);
		}
		return originalString;
	}

	/**
	 * Generic method to parse name and ledger code concatenated by '-' e.g "TEST - 1234"
	 * 
	 * @param agentName
	 * @return - Name and Code e.g Name as 'Test' and Code as '1234'
	 */
	public static String[] parseForwardingAgent(String agentName) {
		String details[] = new String[2];
		int lastIndex = agentName.lastIndexOf("-");
		details[0] = agentName.substring(0, lastIndex).trim();
		details[1] = agentName.substring(lastIndex + 1, agentName.length()).trim();

		return details;
	}

	/**
	 * Generic method to parse name and code concatenated by '-' e.g "CMA - China Marega America ko"
	 * 
	 * @param agentName
	 * @return - Name and Code e.g Name as 'China Marega America ko' and Code as 'CMA'
	 */
	public static String[] splitByCodeAndName(String value) {
		String details[] = new String[2];
		int firstIndex = value.indexOf("-");
		details[0] = value.substring(0, firstIndex).trim();
		details[1] = value.substring(firstIndex + 1, value.length()).trim();

		return details;
	}

	public static String validate(String emailString) {
		Pattern pattern;
		Matcher matcher;
		String result = "";
		String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(EMAIL_PATTERN);

		if (StringUtils.checkString(emailString).length() > 0) {
			if (!emailString.startsWith(",")) {
				if (emailString.contains(",")) {
					String[] splitEmails = emailString.split(",");
					for (String email : splitEmails) {
						matcher = pattern.matcher(email);
						if (!matcher.matches())
							result += email + ",";
					}
					if (result.trim().length() > 0)
						result = result.substring(0, result.length() - 1);
				} else {
					matcher = pattern.matcher(emailString);
					if (!matcher.matches())
						result += emailString;
				}
			} else {
				result += emailString;
			}
		}
		return result;
	}

	public static boolean equals(String str1, String str2) {
		return ((str1 == null) ? false : (str2 == null) ? true : str1.equals(str2));
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		return ((str1 == null) ? false : (str2 == null) ? true : str1.equalsIgnoreCase(str2));
	}

	/**
	 * Validate Number
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		Pattern p2 = Pattern.compile("^[0-9]+$");
		Matcher m2 = p2.matcher(value);
		if (m2.matches())
			return true;
		else
			return false;
	}

	/**
	 * Sub String
	 * 
	 * @return
	 */
	public static String subString(String value, int endIndex) {
		if (StringUtils.isNotBlank(value) && value.length() > endIndex) {
			value = value.substring(0, endIndex);
		}
		return value;
	}

	/**
	 * Validate password with regular expression ( # Start of group (?=.*\d) # must contains one digit from 0-9
	 * (?=.*[a-z]) # must contains one lowercase characters (?=.*[A-Z]) # must contains one uppercase characters
	 * (?=.*[@#$%]) # must contains one special symbols in the list "@#$%" . # match anything with previous condition
	 * checking {6,20} # length at least 6 characters and maximum of 20 ) # End of group
	 * 
	 * @param password password for validation
	 * @return true valid password, false invalid password
	 */
	public static boolean validatePassword(final String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();

	}

	public static void main(String[] args) {
		System.out.println(validatePassword("Test!2345"));
	}
}
