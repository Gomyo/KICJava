CUI - Character User Interface
    terminal
        sysout 메서드
        args / system.in
GUI - Graphic User Interface
        html
            위젯(컴포넌트)
                출력
                입력
            이벤트
                마우스
                키보드
                시스템
    
GUI를 그릴 수 있는 라이브러리
    AWT(Abstract Window Toolkit) - 전통적 디자인
    Swing
        JFC(Java Foundation Class) - 조금 발전됨
    Java FX - 좋긴 좋은데 지나치게 느림
    SWT(Standard Widget Toolkit) - IBM이 만듬(eclipse 개발사)

java -jar notepad.jar로 jar 파일 실행

java.awt
    Button
java.swing
    JButton
컨테이너
    *레이아웃
        컨테이너(Panel)
            다른 컨테이너
            컴포먼트

    window(거의 쓰는 일은 없음)
        frame (O)
            dialog
            panel
            ScrollPane

    *window builder(install 1.9.3 stable)
        JLabel      - 출력
        JButton     - 실행
            이벤트
                    마우스 클릭
                    익명 이너클래스
                    버튼.addMouseListener(인터페이스 구현)
                        MouseListener
                            마우스 동작에 관한 메서드
        JTextField  - 입력