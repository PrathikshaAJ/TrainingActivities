let todos = []
 
/*function addTask(){
    const taskInput=document.getElementById('task')
    todos.push(taskInput.value);
    taskInput.value='';//clean input field
    console.log('TaslAdded',todos);
}*/
 
document.getElementById('btn').addEventListener('click', function () {
    const taskInput = document.getElementById('task')
    todos.push(taskInput.value)
    taskInput.value = ''//clean input field
    displayData()
})
 
function displayData() {
    const taskList = document.getElementById('tasks')
    if (todos.length == 0) {
        taskList.innerHTML = `<li class='list-group-item'>The list is empty</li>`
    }
    else {
        let html = ''
        for (let t of todos) {
            html += `<li class='list-group-item'>${t}
            <button class='btn btn-danger float-end' onclick='deleteTask("${t}")'>Delete</button>
            </li>`
        }
        console.log(html);
        taskList.innerHTML = html
    }
}
 
function deleteTask(task) {
    let foundIndex = undefined
    for (let i = 0; i < todos.length; i++) {
        if (todos[i] == task) {
            foundIndex = i;
            break;
        }
    }
    if (foundIndex != undefined) {
        todos.splice(foundIndex, 1);
        alert('Task Deleted!!')
        displayData()
    }
}
 
displayData()


