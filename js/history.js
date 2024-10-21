document.addEventListener('DOMContentLoaded', () => {
    fetch(' /data/measurementsHistory.json')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.querySelector('#data-table tbody');
            const pagination = document.querySelector('#pagination');
            const rowsPerPage = 10;
            const totalPages = Math.ceil(data.Labels.length / rowsPerPage);
            
            let currentPage = 1;

            function renderTable(page) {
                tableBody.innerHTML = '';
                const start = (page - 1) * rowsPerPage;
                const end = start + rowsPerPage;
                
                data.Labels.slice(start, end).forEach((label, index) => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${label}</td>
                        <td>${data.temperature[start + index]}</td>
                        <td>${data.humidity[start + index]}</td>
                        <td>${data.brightness[start + index]}</td>
                    `;
                    tableBody.appendChild(row);
                });
            }

            function renderPagination() {
                pagination.innerHTML = '';
                const prevPage = document.createElement('li');
                prevPage.classList.add('page-item');
                prevPage.innerHTML = `<a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>`;
                prevPage.addEventListener('click', (e) => {
                    e.preventDefault();
                    if (currentPage > 1) {
                        currentPage--;
                        renderTable(currentPage);
                        renderPagination();
                    }
                });
                pagination.appendChild(prevPage);

                for (let i = 1; i <= totalPages; i++) {
                    const pageItem = document.createElement('li');
                    pageItem.classList.add('page-item');
                    if (i === currentPage) {
                        pageItem.classList.add('active');
                    }
                    pageItem.innerHTML = `<a class="page-link" href="#">${i}</a>`;
                    pageItem.addEventListener('click', (e) => {
                        e.preventDefault();
                        currentPage = i;
                        renderTable(currentPage);
                        renderPagination();
                    });
                    pagination.appendChild(pageItem);
                }

                const nextPage = document.createElement('li');
                nextPage.classList.add('page-item');
                nextPage.innerHTML = `<a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>`;
                nextPage.addEventListener('click', (e) => {
                    e.preventDefault();
                    if (currentPage < totalPages) {
                        currentPage++;
                        renderTable(currentPage);
                        renderPagination();
                    }
                });
                pagination.appendChild(nextPage);
            }

            renderTable(currentPage);
            renderPagination();
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
});