package com.pcwk.ehr.cmn;

public class StringUtil {

	public final static String
	     CONTENT_UTF_8="text/html;charset=UTF-8";
	
	
	/**
	 * <table>
	 * <tr>
	 * <td><< < 1 2 3 4 5 6 7 8 9 10 > >></td>
	 * </tr>
	 * </table>
	 * 
	 * @param maxNum      : 총글수(21)
	 * @param currPageNo: 1
	 * @param rowPerPage  : 10
	 * @param bottomCount : 10
	 * @param url         : /WEB_H01/board/board.do?work_div=doRetrieve
	 * @param scriptName  : doRetrieve
	 * @return
	 */
	public static String renderPaging(int maxNum, int currPageNo, int rowPerPage, int bottomCount, String url,
			String scriptName) {

		/**
		 * 총글수: 21 
		 * 현재페이지: 1 
		 * 한페이지에 보여질 행수: 10 
		 * 바닥에 보여질 페이지 수: 10 
		 * << 시작페이지 < bottomCount :
		 * -10개씩 > bottomCount : +10개씩 >> 마지막 page
		 * 
		 * << < 1 2 3 4 5 6 7 8 9 10 > >>
		 */

		int maxPageNo = ((maxNum - 1) / rowPerPage) + 1;// 3
		int startPageNo = ((currPageNo - 1) / bottomCount) * bottomCount + 1;// 1
		int endPageNo = ((currPageNo - 1) / bottomCount + 1) * bottomCount;// 10

		int nowBlockNo = ((currPageNo - 1) / bottomCount) + 1;// 1
		int maxBlockNo = ((maxNum - 1) / bottomCount) + 1;// 3

		int inx = 0;
		// html
		StringBuilder html = new StringBuilder();

		if (currPageNo > maxPageNo) {
			return "";
		}

		html.append("<table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">   \n");
		html.append("<tr>                       \n");
		html.append("<td align=\"center\">                                                                    \n");
		html.append("<ul class=\"pagination pagination-sm\">                                                  \n");

		// <<
		if (nowBlockNo > 1 && nowBlockNo <= maxBlockNo) {
			html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url + "', 1 );\">  \n");
			html.append("&laquo;   \n");
			html.append("</a></li> \n");
		}

		// <
		if (startPageNo > bottomCount) {
			html.append("<li class=\"active\"> <a href=\"javascript:" + scriptName + "( '" + url + "',"
					+ (startPageNo - bottomCount) + ");\"> \n");
			html.append("<        \n");
			html.append("</a></li>     \n");
		}

		// 1 2 3 ... 10 (숫자보여주기)
		for (inx = startPageNo; inx <= maxPageNo && inx <= endPageNo; inx++) {
			if (inx == currPageNo) {// 현재 page
				html.append("<li  class=\"disabled\" 	>");
				html.append("<a  href=\"javascript:#\"  > ");
				html.append(inx);
				html.append("</a> \n");
				html.append("</li>");
			} else {
				html.append("<li  class=\"active\">");
				html.append("<a  href=\"javascript:" + scriptName + "('" + url + "'," + inx + ");\"  > ");
				html.append(inx);
				html.append("</a> \n");
				html.append("</li>");
			}
		}

		// >

		if (maxPageNo > inx) {
			html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "',"
					+ ((nowBlockNo * bottomCount) + 1) + ");\"> \n");
			html.append(">                       \n");
			html.append("</a></li>              \n");
		}

		// >>
		if (maxPageNo > inx) {
			html.append("<li class=\"active\"><a href=\"javascript:" + scriptName + "('" + url + "'," + maxPageNo
					+ ");\">      \n");
			html.append("&raquo;     \n");
			html.append("</a></li>    \n");
		}

		html.append("</td>   \n");
		html.append("</tr>   \n");
		html.append("</table>   \n");

		return html.toString();
	}	
	/**  
	 * request null처리 함수
	 * @param input : 입력
	 * @param replace : 치환
	 * @return String:앞뒤 빈공간 제거된 문자열
	 */
	public static String nvl(String input,String replace) {
		if(null == input || input.equals("")) {
			input = replace;
		}
		
		return input.trim();
	}
	
}

