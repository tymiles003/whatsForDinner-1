$(document).ready(function() {
    //Get all the dishIngredientRows to set the addIngredientsRows counter to the correct value

    //Ajax call to fill in the ingredientQuantityUnitsOptionsString
    $.ajax({
        url: "/ingredient/quantityUnits",
        type: "GET",
        dataType: "json",
        success: function(data, textStatus, xhr) {
            ingredientUnitsOptionsString = data;
            $.each(data, function(i, ingredientUnit) {
                ingredientUnitsOptionsString += '<option value="' + ingredientUnit.id + '">' + ingredientUnit.name + '</option>'
            });
        },
        error: function(xhr, textStatus, errorThrown) {
            error(errorThrown);
        }
    });

    $('#search-input').typeahead({
        minLength: 2,
        highlight: true
    },
    {
        name: 'ingredients',
        source: function(q, sync, async) {
            var trimmedSearchValue = $.trim(q);
            $.ajax({
                url: "/ingredient/search?searchValue="+trimmedSearchValue,
                type: "GET",
                dataType: "json",
                success: function(data, textStatus, xhr) {
                    ingredients = [];
                    map = {};
                    $.each(data, function(i, ingredient) {
                        map[ingredient.name] = ingredient;
                        ingredients.push(ingredient.name);
                    });
                    async(ingredients);
                },
                error: function(xhr, textStatus, errorThrown) {
                    alert("ERROR ERROR " + errorThrown);
                }
            });
        }
      }).bind('typeahead:select', function(event, suggestion) {
        $('#addDishIngredientRow').val(map[suggestion].id);
        $('#addDishIngredientRow').click();
      });
});