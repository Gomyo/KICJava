GUI
Network
1. 웹서버에 대한 요청 (html)
2. Client / Server (Socket Program : chatting)

1. 웹서버에 대한 요청 (html)
    * html tag ->

    - 주기적으로 데이터 읽는 기법(특정 부분)
    => 가격비교

    공개 html   - 비공식
        html 분석
    OpenAPI     - 공식
        csv     -,(tab) 구분자 양식
        xml     - html 형태로 제공
        json    - 자바스크립트 객체 {}

    네이버 웹크롤링

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