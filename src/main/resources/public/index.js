new Vue({
    el: '#indexVue',
    data: {
        productos: [],
        producto: {}
    },
    created() {
        let $vue = this;
        $vue.allProductos();
    },
    methods: {
        inicializarDatos(item) {
            let $vue = this;
            $vue.producto = Object.assign({}, item);
        },
        editar() {
            let $vue = this;
            $.ajax({
                url: "/posts",
                method: "put",
                data: JSON.stringify($vue.producto),
                contentType: 'application/json',
                dataType: 'json',
                success: function (response) {
                    if (response.success) {
                        $vue.allProductos();
                        $('#modalProductos').modal('hide');
                        alert(response.message, "success");
                    } else {
                        alert(response.message, "error");
                    }
                }
            });
        },
        nuevo() {
            let $vue = this;
            $.ajax({
                url: "/posts",
                method: "post",
                data: JSON.stringify($vue.producto),
                contentType: 'application/json',
                dataType: 'json',
                success: function (response) {
                    if (response.success) {
                        $vue.allProductos();
                        $('#modalProductos').modal('hide');

                        alert(response.message, "success");
                    } else {
                        alert(response.message, "error");
                    }
                }
            });
        },
        allProductos() {
            let $vue = this;
            $.ajax({
                url: "/posts",
                method: "get",
                contentType: 'application/json',
                dataType: 'json',
                success: function (response) {
                    if (response.success) {
                        $vue.productos = response.data;
                    } else {
                        notify(response.message, "error");

                    }
                }
            });
        }
    }
});
