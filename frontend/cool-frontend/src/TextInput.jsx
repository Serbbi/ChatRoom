import './TextInput.css';

export default function TextInput({setMessages, messages, chatId}) {
    const userId = localStorage.getItem("userid");
    function handleSendText() {
        const text = document.querySelector('.textinput').value;
        if(text) {
            // setMessages([...messages, {message: text}]);
            fetch(`http://localhost:8080/chat/${chatId}/messages`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({content: text, senderId: userId, timestamp: new Date()})
            })
                .then(r => r.json())
                .then(data => {
                    console.log(data);
                    setMessages([...messages, data]);
                })
                .catch(e => console.error(e));
        }
    }

    return (
        <div className={"textinputcontainer"}>
            <input type="text" placeholder="Type here" className={"textinput"}/>
            <button className={"textinputbutton"} onClick={handleSendText}>Send</button>
        </div>
    )
}