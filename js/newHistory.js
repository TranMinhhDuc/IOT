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
            const pageSizeSelect = document.querySelector('#page-size');
            const searchTimeInput = document.querySelector('#search-time');
            const searchTempInput = document.querySelector('#search-temp');
            const searchBtn = document.querySelector('#search-btn');

            let rowsPerPage = parseInt(pageSizeSelect.value);
            let filteredData = data; // Use filtered data for searching and pagination
            let currentPage = 1;

            function totalPages() {
                return Math.ceil(filteredData.Labels.length / rowsPerPage);
            }

            function renderTable(page) {
                tableBody.innerHTML = '';
                const start = (page - 1) * rowsPerPage;
                const end = start + rowsPerPage;
                
                filteredData.Labels.slice(start, end).forEach((label, index) => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${label}</td>
                        <td>${filteredData.temperature[start + index]}</td>
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

                for (let i = 1; i <= totalPages(); i++) {
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
                    if (currentPage < totalPages()) {
                        currentPage++;
                        renderTable(currentPage);
                        renderPagination();
                    }
                });
                pagination.appendChild(nextPage);
            }

            function filterData() {
                const timeSearch = searchTimeInput.value.trim().toLowerCase();
                const tempSearch = searchTempInput.value.trim();

                filteredData = {
                    Labels: data.Labels.filter((label, index) => {
                        const matchesTime = timeSearch === '' || label.toLowerCase().includes(timeSearch);
                        const matchesTemp = tempSearch === '' || data.temperature[index].toString().includes(tempSearch);
                        return matchesTime && matchesTemp;
                    }),
                    temperature: data.temperature.filter((_, index) => {
                        const matchesTime = timeSearch === '' || data.Labels[index].toLowerCase().includes(timeSearch);
                        const matchesTemp = tempSearch === '' || data.temperature[index].toString().includes(tempSearch);
                        return matchesTime && matchesTemp;
                    }),
                };
            }

            // Handle search button click
            searchBtn.addEventListener('click', () => {
                filterData();
                currentPage = 1; // Reset to the first page
                renderTable(currentPage);
                renderPagination();
            });

            // Handle page size change
            pageSizeSelect.addEventListener('change', () => {
                rowsPerPage = parseInt(pageSizeSelect.value);
                currentPage = 1; // Reset to the first page
                renderTable(currentPage);
                renderPagination();
            });

            // Initial rendering
            filterData();
            renderTable(currentPage);
            renderPagination();
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
});
