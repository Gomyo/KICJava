GUI
Network
1. 웹서버에 대한 요청 (html)
2. Client / Server (Socket Program : chatting)

1. 웹서버에 대한 요청 (Web Crawling / Scraping)
    * html tag ->

    - 주기적으로 데이터 읽는 기법(특정 부분)
    => 가격비교

    공개 html   - 비공식
        html(jsoup) 분석
    OpenAPI(Library)     - 공식
        csv     -,(tab) 구분자 양식
        xml     - html 형태로 제공
        json    - 자바스크립트 객체 {}
    네이버 웹크롤링

2. 소켓 프로그램 - 쌍방향 교신에 의해 작성되는 프로그램
Client / Server
P2P (Blockchain의 특징)

Protocol
    TCP - 전화(1:1) - 신뢰성 - 채팅의 원리
    UDP - 인터넷 방송 - 신뢰성이 조금 떨어지더라도, 빠른 데이터의 전송이 필요한 경우.

    java.net.ServerSocket (대기)
    java.net.Socket (접속)

    대기와 접속이 동시에 작동해야 한다.

<geocoding 개인 키>

https://maps.googleapis.com/maps/api/geocode/json?
address=1600+Amphitheatre+Parkway,+Mountain+View,+CA
&
key=AIzaSyBCEEd5naSLLZf1nDhpToFU_9MTyt1BdsY
[xml도 가능]
https://maps.googleapis.com/maps/api/geocode/xml?address=강남역&key=AIzaSyBCEEd5naSLLZf1nDhpToFU_9MTyt1BdsY

1. String - 메소드
2. 각각 라이브러리 사용 (json)

Q1
서울시청
위도 : 
경도 : 
형태로 출력되게 해보자
contains 사용 아이디어 떠올린거 좋았다.

https://code.google.com/archive/p/json-simple/downloads
json-simple-1.1.1.jar 다운로드

jsonlint.com

#### 온라인 json 파일을 가져오는 방법
1. 문자열 저장한 뒤 parsing
2. 네트워크 상에서 parsing

#### html문서 처리 (for crawling)
    jsoup
    https://jsoup.org - jsoup 다운로드 완료

    python beautifulsoup
    -> 

    * parser - 구문 분석기

#### 채팅
한 서버에 여러명이 접속할수 있게 하려면 소켓에 한명이 붙었을 때 스레드 하나를 만들며 분리하여 관리.
여기서 Thread를 관리하는 부분을 Chatroom이라고 함

chat1 package 개량 1 : 대화명을 argument로 넣는 것이 아니라 채팅방에 입장한 이후, 대화명을 입력하라는 텍스트를 띄우고 입력받기. 그리고 클라이언트 exit 입력하면 클라이언트 종료하자.