let page = 0;
const size = 5;

function displayBlogs(data) {
    let html = "";
    data.forEach(blog => {
        html += `<div>
            <h3>${blog.title}</h3>
            <p>${blog.content}</p>
            <hr>
        </div>`;
    });
    $("#blog-list").append(html);
}

function loadBlogs() {
    $.ajax({
        url: `/api/blogs?page=${page}&size=${size}`,
        method: "GET",
        success: function (data) {
            displayBlogs(data);
            page++;
        }
    });
}

function searchBlogs(keyword) {
    $.ajax({
        url: `/api/blogs/search?keyword=${keyword}`,
        method: "GET",
        success: function (data) {
            $("#blog-list").empty();
            displayBlogs(data);
        }
    });
}

$(document).ready(function () {
    loadBlogs();

    $("#load-more").click(function () {
        loadBlogs();
    });

    $("#search-form").submit(function (e) {
        e.preventDefault();
        const keyword = $("#search-input").val();
        searchBlogs(keyword);
    });
});
