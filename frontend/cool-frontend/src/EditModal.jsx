import './EditModal.css';
import {useState} from "react";

export default function EditModal({chat, onClose, chats, setChats}) {
    const [chatName, setChatName] = useState(chat.chatName);
    function handleClick() {
        fetch('http://localhost:8080/chat/' + chat.id, {
            method: 'DELETE'
        })
            .then(r => {
                onClose();
                const newChats = chats.filter(c => c.id !== chat.id);
                setChats(newChats);
            })
            .catch(e => console.error(e));
    }

    function handleNameChange(event) {
        setChatName(event.target.value);
    }

    function handleSave() {
        fetch('http://localhost:8080/chat/' + chat.id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({"chatName": chatName})
        })
            .then(r => r.json())
            .then(data => {
                console.log(data);
                const newChats = chats.map(c => {
                    if (c.id === chat.id) {
                        return data;
                    }
                    return c;
                });
                setChats(newChats);
                onClose();
            })
            .catch(e => console.error(e));
    }

    return (
        <div className={"editmodal"}>
            <div className={"modalcontent"}>
                <h2>Edit Chat Room</h2>
                <input type="text" value={chatName} onChange={handleNameChange}/>
                <button onClick={handleSave}>Save</button>
                <button onClick={handleClick}>Delete</button>
                <button onClick={onClose}>Close</button>
            </div>
        </div>
    )
}