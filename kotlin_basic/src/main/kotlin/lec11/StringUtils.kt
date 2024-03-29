package lec11

// 클래스를 두지 않고, 파일 상단에 함수를 만들면 유틸성으로 사용이 가능
fun isDirectoryPath(path: String): Boolean {
    return path.endsWith("/")
}

