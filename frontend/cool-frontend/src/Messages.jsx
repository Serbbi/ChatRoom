import {useState} from "react";

export default function Messages({messages}) {
    return (
        <ul>
            {messages.length > 0 && messages.map(m => <li key={m.id}>{m.content}</li>)}
        </ul>
    )
}