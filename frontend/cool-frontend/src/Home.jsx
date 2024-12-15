import {useEffect, useState} from "react";
import EditModal from "./EditModal.jsx";
import TextInput from "./TextInput.jsx";
import Messages from "./Messages.jsx";
import './Home.css';

export default function Home({username}) {
    const [chats, setChats] = useState([]);
    const [showEditModal, setShowEditModal] = useState(false);
    const [selectedChat, setSelectedChat] = useState(null);

    const [messages, setMessages] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/chats')
            .then(r => r.json())
            .then(data => {
                console.log(data);
                setChats(data);
            })
            .catch(e => console.error(e));
    }, []);

    useEffect(() => {
        if(selectedChat) {
            fetch(`http://localhost:8080/chat/${selectedChat.id}/messages`)
                .then(r => r.json())
                .then(data => {
                    setMessages(data);
                    console.log("messages", data);
                })
        }
    }, [selectedChat]);

    function handleCreateChat() {
        fetch('http://localhost:8080/chat', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({chatName: 'New Chat'})
        })
            .then(r => r.json())
            .then(data => {
                console.log(data);
                setChats([...chats, data]);
            })
            .catch(e => console.error(e));
    }

    return (
        <div className={"home"}>
            <h1 className={"title"}>Welcome to the Home Page {username}</h1>
            <div className={"content"}>
                <div className={"leftside"}>
                    <ul className={"chatlist"}>
                        {
                            chats.map(chat => <li onClick={() => {setSelectedChat(chat)}} key={chat.id} className={"chatitem"}>{chat.chatName}<button onClick={() => setShowEditModal(true)}>edit</button></li>)
                        }
                    </ul>
                    {selectedChat && showEditModal &&
                        <EditModal chat={selectedChat} onClose={() => setShowEditModal(false)} show={showEditModal} chats={chats} setChats={setChats} />
                    }
                    <button onClick={handleCreateChat}>Create Chat Room</button>
                </div>
                <div className={"rightside"}>
                    <Messages messages={messages}/>
                    <TextInput setMessages={setMessages} messages={messages} chatId={selectedChat ? selectedChat.id : null}/>
                </div>
            </div>
        </div>
    )
}