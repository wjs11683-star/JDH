const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click', event=>{
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method : 'DELETE'
        })
        .then(()=>{
            alert('삭제가 완료 되었습니다.');
            location.replace('/articles');
        });
    });
}
const modifyButton = document.getElementById('modify-btn');

if(modifyButton){
    modifyButton.addEventListener('click', event->{
        let parmas = new URLSearchParams(location.search);
        let id = params.get('id')
    })
}

/*
해당 코드는 HTML -> id를 delete-btn 으로 설정한 엘리먼트를 찾아 클릭 이벤트가 발생시
fetch() 메서드에 이어 then() 메서드는 fetch() 가 잘 완료되면 연이어 실행됨
alert() 메서는 then() 메서드가 실행되는 시점에 웹 브라우저에서 화면으로 삭제가 완료되었음을 알림
location.replace() 실행시 사용자의 웹 브라우저 화면을 현재 주소를 기반해 옮겨주는 역할
*/