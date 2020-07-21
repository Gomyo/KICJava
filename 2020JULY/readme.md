클래스 - 인스턴스
            = tomcat lib
request     = javax.servlet.http.HttpServletRequest 가장 중요!
response    = javax.servlet.http.HttpServletResponse
session     = ...
application = 
out

    html
    JSP 태그를 추가(서버)
        <%@ -directive
            page (필수)
            include
            taglib
        <%! - declaration (X)
            멤버필드
            메서드(O)
        <% - scriptlet(메서드)
            java source
                지역변수
                제어문
        <%= - expression
            out.println을 대체

*기본적인 라이브러리

다이나믹 웹 브라우저에 JDBC 라이브러리는 빌드 퍼스트 삽입하지 않고
WebContent - Web-inf-lib에 붙여넣기!