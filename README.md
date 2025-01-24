# 🧩 Algorithm Study 

알고리즘 공부를 위한 스터디입니다.

2025.01.31 ~ 02.27 (4W)

<br/>

## 📆 Curriculum
총 8주로 계획되어 있으며, 2월 일정은 1~4주차입니다.

| 주차 | 내용 |
|:-----|:----|
| 1주차 | 스택, 큐, 우선순위 큐 |
| 2주차 | 정렬, 이분탐색 |
| 3주차 | 투 포인터, 슬라이딩 윈도우 |
| 4주차 | 재귀, 분할정복 |
| 5주차 | 그래프 탐색 (DFS, BFS) |
| 6주차 | 이진 검색 트리, 해시, 집합 |
| 7주차 | 백트래킹, 비트마스크 |
| 8주차 | 그리디, 동적 계획법(DP) |

<br/>


## 💻 Rules
- **PART 1** : 금토일
  + 개념 공부 후 마크다운 문서로 정리
  + 개념 이해를 위한 기본 문제 풀이
  + 일요일 23:59까지 PR

- **PART 2** : 월화수
  + 제공된 문제 중 2문제 풀이
  + 수요일 22:00까지 PR

- **PART 3** : 목
  + 오프라인 코드 리뷰

<br/>

### 📍 Convention Rule
- **Commit Message**

  + `[ Wn / PART n] 자유기술`
  + ex) [ W2 / PART 2] 0000 문제 풀이

- **Pull Request**

  + `Wn / PART n / 이름`
  + ex) W3 / PART 2 / 홍길동

<br/>

## ⚙️ Guide

Pull Request를 위한 가벼운 가이드를 제공합니다.


1. 오른쪽 상단의 `Fork`버튼을 눌러 개인 저장소로 복사한다.

2. Fork한 저장소에서 `Code` 버튼을 눌러 clone 주소를 복사한 후, 원하는 로컬 위치에 `git clone`한다.
```
git clone https://github.com/......
cd Feb-Algorithm
```

3. pull을 편리하게 하기 위해 원본 저장소를 등록한다.
```
git remote add upstream https://github.com/8weekAlgorithm/Feb-Algorithm.git
```

4. commit할 branch를 생성하고 이동한다.
```
git branch <branch name>
git checkout <branch name>
```

5. 작업 후 개인 저장소에 commit 및 push한다.
```
git add .
git commit -m "[ Wn / PART n] 자유기술"
git push origin <branch name>
```
6. push 후 본인의 저장소로 돌아오면 `Pull Request` 버튼이 활성화된다. 해당 버튼을 클릭해 Pull Request를 진행한다. 

7.  Pull Request가 merge된 후, 원본 저장소의 변경사항을 가져와 로컬 브랜치를 업데이트한다.
```
git pull upstream main
```